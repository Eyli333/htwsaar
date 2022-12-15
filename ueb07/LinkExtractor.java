import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {
    private static final String LINK_REGES = "<a href=\"(.+?)\">(.+?)</a>";
    private static final Pattern LINK_PATTERN = Pattern.compile(LINK_REGES);
    static Scanner scanner = new Scanner(System.in);
    
    public void printf(String format, Object... args) {
        System.out.printf(format + "\n", args);
    }

    public static void main(String[] args) {
        new LinkExtractor().run();
    }

    public void run() {

        int linkCount = 0;
        int lineCount = 0;

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineCount++;

            Matcher linkMatcher = LINK_PATTERN.matcher(line);
            if (linkMatcher.find()) {
                linkCount++;

                String linkText = linkMatcher.group(2);
                String linkUrl = linkMatcher.group(1);

                printf("%s: %s, Anzahl Zeichen: %d", linkText, linkUrl, linkUrl.length());

            }
        }

        //System.out.println(linkCount + " Links wurden in " + lineCount + " Zeilen gefunden.");
        //System.out.println(String.format("%d Links wurden in %d Zeilen gefunden", linkCount, lineCount));
        //System.out.printf("%d Links wurden in %d Zeilen gefunden", linkCount, lineCount);
        printf("%d Links wurden in %d Zeilen gefunden", linkCount, lineCount);

        scanner.close();
    }
}
