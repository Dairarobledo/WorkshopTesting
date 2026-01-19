package es.fplumara.dam1.workshoptesting.reporting;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ReportExporter {

    private final Formatter formatter;

    public ReportExporter(Formatter formatter) {
        this.formatter = formatter;
    }

    public Path export(Path folder, String reportName, String title, String body) throws IOException {
        String content = formatter.formatReport(title, body);

        Path file = folder.resolve(reportName + ".txtt");

        Files.createDirectories(folder);
        Files.writeString(file, content);
        return file;
    }
}