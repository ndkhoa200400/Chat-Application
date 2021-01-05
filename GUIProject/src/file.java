
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.DatagramPacket;
import java.net.Socket;
import java.util.Date;
import java.util.Iterator;

import javax.imageio.stream.ImageInputStream;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

import java.io.Serializable;

public class file implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 7855345646601021980L;
    private String destinationDirectory;
    private String sourceDirectory;
    private String filename;
    private long fileSize;
    private String fileType;
    private byte[] dataBytes;
    private String status;
    private long lastModified;

    private String sender;
    private String recver;

    file(String source, String destination) {
        this.sourceDirectory = source;
        this.destinationDirectory = destination;
    }

    file() {
    }

    public String getDestinationDirectory() {
        return destinationDirectory;
    }

    public void setDestinationDirectory(String destinationDirectory) {
        this.destinationDirectory = destinationDirectory;
    }

    public long getLastModified() {
        return lastModified;
    }
    
    public Date getDate(){
        Date date = new Date(this.getLastModified());
        return date;
    }

    public String getSourceDirectory() {
        return sourceDirectory;
    }

    public void setSourceDirectory(String sourceDirectory) {
        this.sourceDirectory = sourceDirectory;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public void setLastModified(long lastModified) {
        this.lastModified = lastModified;
    }

    public long getFileSize() {
        return fileSize;
    }

    public String getFileType() {
        String extension = "";
        int i = this.getFilename().lastIndexOf('.');
        if (i > 0) {
            extension = this.getFilename().substring(i+1);
        }
        this.setFileType(extension);
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public void setFileSize(long fileSize) {
        this.fileSize = fileSize;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setDataBytes(byte[] dataBytes) {
        this.dataBytes = dataBytes;
    }

    public byte[] getDataBytes() {
        return dataBytes;
    }

    public void setCommunication(String send, String recv) {
        this.sender = send;
        this.recver = recv;
    }

    public String getRecver() {
        return recver;
    }

    public String getSender() {
        return sender;
    }

    public void getFileInfo(String source) {
        try {
            File sourceFile = new File(source);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(sourceFile));

            byte[] bytes = new byte[(int) sourceFile.length()];
            // get file info
            bis.read(bytes, 0, bytes.length);
            this.setFilename(sourceFile.getName());
            this.setDataBytes(bytes);
            this.setFileSize(sourceFile.length());
            this.setLastModified(sourceFile.lastModified());
            this.setFileType(this.getFileType());

        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }

    public boolean createFile() {
        BufferedOutputStream bos = null;
        try {
            if (this != null) {
                File fileRecv = new File(
                        this.getDestinationDirectory() + this.sender + "_" + this.recver+"_"+ this.getFilename());
                bos = new BufferedOutputStream(new FileOutputStream(fileRecv));
                // write file content
                bos.write(this.getDataBytes());
                bos.flush();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }
}


