package com.easydeliver.clientapp.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import retrofit.mime.TypedOutput;

/**
 * Created by tomlee on 11/2/16.
 */
public class MultipartTypedOutputCustom implements TypedOutput {

    private static final class MimePart {
        private final TypedOutput body;
        private final String name;
        private final boolean isFirst;
        private final String boundary;

        private byte[] partBoundary;
        private byte[] partHeader;
        private boolean isBuilt;

        public MimePart(String name, TypedOutput body, String boundary, boolean isFirst) {
            this.name = name;
            this.body = body;
            this.isFirst = isFirst;
            this.boundary = boundary;
        }

        public void writeTo(OutputStream out) throws IOException {
            build();
            out.write(partBoundary);
            out.write(partHeader);
            body.writeTo(out);
        }

        public long size() {
            build();
            if (body.length() > -1) {
                return body.length() + partBoundary.length + partHeader.length;
            } else {
                return -1;
            }
        }

        private void build() {
            if (isBuilt) return;
            partBoundary = buildBoundary(boundary, isFirst, false);
            partHeader = buildHeader(name, body);
            isBuilt = true;
        }
    }

    private final List<MimePart> mimeParts = new LinkedList<MimePart>();

    private final byte[] footer;
    private final String boundary;
    private long length;

    public MultipartTypedOutputCustom() {
        this(UUID.randomUUID().toString());
    }

    MultipartTypedOutputCustom(String boundary) {
        this.boundary = boundary;
        footer = buildBoundary(boundary, false, true);
        length = footer.length;
    }

    List<byte[]> getParts() throws IOException {
        List<byte[]> parts = new ArrayList<byte[]>(mimeParts.size());
        for (MimePart part : mimeParts) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            part.writeTo(bos);
            parts.add(bos.toByteArray());
        }
        return parts;
    }

    public void addPart(String name, TypedOutput body) {
        if (name == null) {
            throw new NullPointerException("Part name must not be null.");
        }
        if (body == null) {
            throw new NullPointerException("Part body must not be null.");
        }

        MimePart part = new MimePart(name, body, boundary, mimeParts.isEmpty());
        mimeParts.add(part);

        length += part.size();
    }

    public int getPartCount() {
        return mimeParts.size();
    }

    @Override public String fileName() {
        return null;
    }

    @Override public String mimeType() {
        return "multipart/form-data; boundary=" + boundary;
    }

    @Override public long length() {
        return length;
    }

    @Override public void writeTo(OutputStream out) throws IOException {
        for (MimePart part : mimeParts) {
            part.writeTo(out);
        }
        out.write(footer);
    }

    private static byte[] buildBoundary(String boundary, boolean first, boolean last) {
        try {
            StringBuilder sb = new StringBuilder();
            if (!first) {
                sb.append("\r\n");
            }
            sb.append("--");
            sb.append(boundary);
            if (last) {
                sb.append("--");
            } else {
                sb.append("\r\n");
            }
            return sb.toString().getBytes("UTF-8");
        } catch (IOException ex) {
            throw new RuntimeException("Unable to write multipart boundary", ex);
        }
    }

    private static byte[] buildHeader(String name, TypedOutput value) {
        try {
            //text/plain; charset=US-ASCII
            StringBuilder headers = new StringBuilder();
            headers.append("Content-Disposition: form-data; name=\"");
            headers.append(name+"\"");
            if (value.fileName() != null) {
//                headers.append("\"; filename=\"");
                headers.append("; filename=\"");
                headers.append(value.fileName());
            }

            if(value.mimeType().contains("image")) {
                headers.append("\"\r\nContent-Type: ");
                headers.append(value.mimeType());
            }

            if (value.length() != -1) {
                headers.append("\r\nContent-Length: ").append(value.length());
            }



            headers.append("\r\nContent-Transfer-Encoding: binary\r\n\r\n");

            return headers.toString().getBytes("UTF-8");
        } catch (IOException ex) {
            throw new RuntimeException("Unable to write multipart header", ex);
        }
    }
}