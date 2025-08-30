package kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001¨\u0006\u0003"}, d2 = {"Lkotlin/io/path/FileVisitorImpl;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class FileVisitorImpl extends SimpleFileVisitor<Path> {
    public final FileVisitResult postVisitDirectory(Object obj, IOException iOException) {
        Path path = (Path) obj;
        Intrinsics.checkNotNullParameter(path, "dir");
        FileVisitResult postVisitDirectory = super.postVisitDirectory(path, iOException);
        Intrinsics.checkNotNullExpressionValue(postVisitDirectory, "postVisitDirectory(...)");
        return postVisitDirectory;
    }

    public final FileVisitResult preVisitDirectory(Object obj, BasicFileAttributes basicFileAttributes) {
        Path path = (Path) obj;
        Intrinsics.checkNotNullParameter(path, "dir");
        Intrinsics.checkNotNullParameter(basicFileAttributes, "attrs");
        FileVisitResult preVisitDirectory = super.preVisitDirectory(path, basicFileAttributes);
        Intrinsics.checkNotNullExpressionValue(preVisitDirectory, "preVisitDirectory(...)");
        return preVisitDirectory;
    }

    public final FileVisitResult visitFile(Object obj, BasicFileAttributes basicFileAttributes) {
        Path path = (Path) obj;
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(basicFileAttributes, "attrs");
        FileVisitResult visitFile = super.visitFile(path, basicFileAttributes);
        Intrinsics.checkNotNullExpressionValue(visitFile, "visitFile(...)");
        return visitFile;
    }

    public final FileVisitResult visitFileFailed(Object obj, IOException iOException) {
        Path path = (Path) obj;
        Intrinsics.checkNotNullParameter(path, "file");
        Intrinsics.checkNotNullParameter(iOException, "exc");
        FileVisitResult visitFileFailed = super.visitFileFailed(path, iOException);
        Intrinsics.checkNotNullExpressionValue(visitFileFailed, "visitFileFailed(...)");
        return visitFileFailed;
    }
}
