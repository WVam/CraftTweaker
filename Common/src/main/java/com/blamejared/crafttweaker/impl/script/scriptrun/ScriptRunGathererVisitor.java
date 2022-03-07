package com.blamejared.crafttweaker.impl.script.scriptrun;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;

final class ScriptRunGathererVisitor extends SimpleFileVisitor<Path> {
    
    private static final PathMatcher scriptFileMatcher = FileSystems.getDefault().getPathMatcher("glob:*.zs");
    private final List<Path> files;
    
    ScriptRunGathererVisitor() {
        
        this.files = new ArrayList<>();
    }
    
    @Override
    public FileVisitResult visitFile(final Path file, final BasicFileAttributes attrs) throws IOException {
        
        super.visitFile(file, attrs);
        if(attrs.isRegularFile()/* || attrs.isSymbolicLink()*/ && scriptFileMatcher.matches(file)) {
            this.files.add(file);
        }
        return FileVisitResult.CONTINUE;
    }
    
    List<Path> files() {
        
        return List.copyOf(this.files);
    }
    
}
