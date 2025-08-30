package androidx.camera.core.imagecapture;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.impl.utils.Exif;
import androidx.camera.core.internal.compat.workaround.InvalidJpegDataParser;
import androidx.camera.core.processing.Operation;
import androidx.camera.core.processing.Packet;
import com.google.auto.value.AutoValue;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import java.util.UUID;

class JpegBytes2Disk implements Operation<In, ImageCapture.OutputFileResults> {
    private static final int COPY_BUFFER_SIZE = 1024;
    private static final int NOT_PENDING = 0;
    private static final int PENDING = 1;
    private static final String TEMP_FILE_PREFIX = "CameraX";
    private static final String TEMP_FILE_SUFFIX = ".tmp";

    @AutoValue
    public static abstract class In {
        @NonNull
        public static In of(@NonNull Packet<byte[]> packet, @NonNull ImageCapture.OutputFileOptions outputFileOptions) {
            return new AutoValue_JpegBytes2Disk_In(packet, outputFileOptions);
        }

        @NonNull
        public abstract ImageCapture.OutputFileOptions getOutputFileOptions();

        @NonNull
        public abstract Packet<byte[]> getPacket();
    }

    private static Uri copyFileToFile(@NonNull File file, @NonNull File file2) throws ImageCaptureException {
        if (file2.exists()) {
            file2.delete();
        }
        if (file.renameTo(file2)) {
            return Uri.fromFile(file2);
        }
        throw new ImageCaptureException(1, "Failed to overwrite the file: " + file2.getAbsolutePath(), (Throwable) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x005e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static android.net.Uri copyFileToMediaStore(@androidx.annotation.NonNull java.io.File r6, @androidx.annotation.NonNull androidx.camera.core.ImageCapture.OutputFileOptions r7) throws androidx.camera.core.ImageCaptureException {
        /*
            java.lang.String r0 = "Failed to write to MediaStore URI: "
            android.content.ContentResolver r1 = r7.getContentResolver()
            java.util.Objects.requireNonNull(r1)
            android.content.ContentValues r2 = r7.getContentValues()
            if (r2 == 0) goto L_0x0019
            android.content.ContentValues r2 = new android.content.ContentValues
            android.content.ContentValues r3 = r7.getContentValues()
            r2.<init>(r3)
            goto L_0x001e
        L_0x0019:
            android.content.ContentValues r2 = new android.content.ContentValues
            r2.<init>()
        L_0x001e:
            r3 = 1
            setContentValuePendingFlag(r2, r3)
            r4 = 0
            r5 = 0
            android.net.Uri r7 = r7.getSaveCollection()     // Catch:{ IOException -> 0x0049, SecurityException -> 0x0047 }
            android.net.Uri r7 = r1.insert(r7, r2)     // Catch:{ IOException -> 0x0049, SecurityException -> 0x0047 }
            if (r7 == 0) goto L_0x003d
            copyTempFileToUri(r6, r7, r1)     // Catch:{ IOException -> 0x003b, SecurityException -> 0x0038, all -> 0x0035 }
            updateUriPendingStatus(r7, r1, r4)
            return r7
        L_0x0035:
            r6 = move-exception
            r5 = r7
            goto L_0x005c
        L_0x0038:
            r6 = move-exception
        L_0x0039:
            r5 = r7
            goto L_0x004a
        L_0x003b:
            r6 = move-exception
            goto L_0x0039
        L_0x003d:
            androidx.camera.core.ImageCaptureException r6 = new androidx.camera.core.ImageCaptureException     // Catch:{ IOException -> 0x003b, SecurityException -> 0x0038, all -> 0x0035 }
            java.lang.String r2 = "Failed to insert a MediaStore URI."
            r6.<init>(r3, r2, r5)     // Catch:{ IOException -> 0x003b, SecurityException -> 0x0038, all -> 0x0035 }
            throw r6     // Catch:{ IOException -> 0x003b, SecurityException -> 0x0038, all -> 0x0035 }
        L_0x0045:
            r6 = move-exception
            goto L_0x005c
        L_0x0047:
            r6 = move-exception
            goto L_0x004a
        L_0x0049:
            r6 = move-exception
        L_0x004a:
            androidx.camera.core.ImageCaptureException r7 = new androidx.camera.core.ImageCaptureException     // Catch:{ all -> 0x0045 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0045 }
            r2.<init>(r0)     // Catch:{ all -> 0x0045 }
            r2.append(r5)     // Catch:{ all -> 0x0045 }
            java.lang.String r0 = r2.toString()     // Catch:{ all -> 0x0045 }
            r7.<init>(r3, r0, r6)     // Catch:{ all -> 0x0045 }
            throw r7     // Catch:{ all -> 0x0045 }
        L_0x005c:
            if (r5 == 0) goto L_0x0061
            updateUriPendingStatus(r5, r1, r4)
        L_0x0061:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.imagecapture.JpegBytes2Disk.copyFileToMediaStore(java.io.File, androidx.camera.core.ImageCapture$OutputFileOptions):android.net.Uri");
    }

    private static void copyFileToOutputStream(@NonNull File file, @NonNull OutputStream outputStream) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    outputStream.write(bArr, 0, read);
                } else {
                    fileInputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static void copyTempFileToUri(@NonNull File file, @NonNull Uri uri, @NonNull ContentResolver contentResolver) throws IOException {
        OutputStream openOutputStream = contentResolver.openOutputStream(uri);
        if (openOutputStream != null) {
            try {
                copyFileToOutputStream(file, openOutputStream);
                openOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        } else {
            throw new FileNotFoundException(uri + " cannot be resolved.");
        }
        throw th;
    }

    @NonNull
    private static File createTempFile(@NonNull ImageCapture.OutputFileOptions outputFileOptions) throws ImageCaptureException {
        try {
            File file = outputFileOptions.getFile();
            if (file == null) {
                return File.createTempFile(TEMP_FILE_PREFIX, TEMP_FILE_SUFFIX);
            }
            String parent = file.getParent();
            return new File(parent, TEMP_FILE_PREFIX + UUID.randomUUID().toString() + getFileExtensionWithDot(file));
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to create temp file.", e);
        }
    }

    private static String getFileExtensionWithDot(File file) {
        String name = file.getName();
        int lastIndexOf = name.lastIndexOf(46);
        if (lastIndexOf >= 0) {
            return name.substring(lastIndexOf);
        }
        return "";
    }

    private static boolean isSaveToFile(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.getFile() != null) {
            return true;
        }
        return false;
    }

    private static boolean isSaveToMediaStore(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.getSaveCollection() == null || outputFileOptions.getContentResolver() == null || outputFileOptions.getContentValues() == null) {
            return false;
        }
        return true;
    }

    private static boolean isSaveToOutputStream(ImageCapture.OutputFileOptions outputFileOptions) {
        if (outputFileOptions.getOutputStream() != null) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003c, code lost:
        throw new androidx.camera.core.ImageCaptureException(1, "Failed to write to OutputStream.", (java.lang.Throwable) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        r3.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0040, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0034 */
    @androidx.annotation.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.net.Uri moveFileToTarget(@androidx.annotation.NonNull java.io.File r3, @androidx.annotation.NonNull androidx.camera.core.ImageCapture.OutputFileOptions r4) throws androidx.camera.core.ImageCaptureException {
        /*
            r0 = 0
            boolean r1 = isSaveToMediaStore(r4)     // Catch:{ IOException -> 0x0034 }
            if (r1 == 0) goto L_0x000e
            android.net.Uri r0 = copyFileToMediaStore(r3, r4)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0030
        L_0x000c:
            r4 = move-exception
            goto L_0x003d
        L_0x000e:
            boolean r1 = isSaveToOutputStream(r4)     // Catch:{ IOException -> 0x0034 }
            if (r1 == 0) goto L_0x001f
            java.io.OutputStream r4 = r4.getOutputStream()     // Catch:{ IOException -> 0x0034 }
            java.util.Objects.requireNonNull(r4)     // Catch:{ IOException -> 0x0034 }
            copyFileToOutputStream(r3, r4)     // Catch:{ IOException -> 0x0034 }
            goto L_0x0030
        L_0x001f:
            boolean r1 = isSaveToFile(r4)     // Catch:{ IOException -> 0x0034 }
            if (r1 == 0) goto L_0x0030
            java.io.File r4 = r4.getFile()     // Catch:{ IOException -> 0x0034 }
            java.util.Objects.requireNonNull(r4)     // Catch:{ IOException -> 0x0034 }
            android.net.Uri r0 = copyFileToFile(r3, r4)     // Catch:{ IOException -> 0x0034 }
        L_0x0030:
            r3.delete()
            return r0
        L_0x0034:
            androidx.camera.core.ImageCaptureException r4 = new androidx.camera.core.ImageCaptureException     // Catch:{ all -> 0x000c }
            java.lang.String r1 = "Failed to write to OutputStream."
            r2 = 1
            r4.<init>(r2, r1, r0)     // Catch:{ all -> 0x000c }
            throw r4     // Catch:{ all -> 0x000c }
        L_0x003d:
            r3.delete()
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.core.imagecapture.JpegBytes2Disk.moveFileToTarget(java.io.File, androidx.camera.core.ImageCapture$OutputFileOptions):android.net.Uri");
    }

    private static void setContentValuePendingFlag(@NonNull ContentValues contentValues, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(i));
        }
    }

    private static void updateFileExif(@NonNull File file, @NonNull Exif exif, @NonNull ImageCapture.OutputFileOptions outputFileOptions, int i) throws ImageCaptureException {
        try {
            Exif createFromFile = Exif.createFromFile(file);
            exif.copyToCroppedImage(createFromFile);
            if (createFromFile.getRotation() == 0 && i != 0) {
                createFromFile.rotate(i);
            }
            ImageCapture.Metadata metadata = outputFileOptions.getMetadata();
            if (metadata.isReversedHorizontal()) {
                createFromFile.flipHorizontally();
            }
            if (metadata.isReversedVertical()) {
                createFromFile.flipVertically();
            }
            if (metadata.getLocation() != null) {
                createFromFile.attachLocation(metadata.getLocation());
            }
            createFromFile.save();
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to update Exif data", e);
        }
    }

    private static void updateUriPendingStatus(@NonNull Uri uri, @NonNull ContentResolver contentResolver, int i) {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentValues contentValues = new ContentValues();
            setContentValuePendingFlag(contentValues, i);
            contentResolver.update(uri, contentValues, (String) null, (String[]) null);
        }
    }

    private static void writeBytesToFile(@NonNull File file, @NonNull byte[] bArr) throws ImageCaptureException {
        FileOutputStream fileOutputStream;
        try {
            fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr, 0, new InvalidJpegDataParser().getValidDataLength(bArr));
            fileOutputStream.close();
            return;
        } catch (IOException e) {
            throw new ImageCaptureException(1, "Failed to write to temp file", e);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    @NonNull
    public ImageCapture.OutputFileResults apply(@NonNull In in) throws ImageCaptureException {
        Packet<byte[]> packet = in.getPacket();
        ImageCapture.OutputFileOptions outputFileOptions = in.getOutputFileOptions();
        File createTempFile = createTempFile(outputFileOptions);
        writeBytesToFile(createTempFile, packet.getData());
        Exif exif = packet.getExif();
        Objects.requireNonNull(exif);
        updateFileExif(createTempFile, exif, outputFileOptions, packet.getRotationDegrees());
        return new ImageCapture.OutputFileResults(moveFileToTarget(createTempFile, outputFileOptions));
    }
}
