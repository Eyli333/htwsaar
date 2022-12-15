import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LinkExtractor {
    //private static final String LINK_REGEX = "<a href=\"(.+?)\">(.+?)</a>";
    private static final String LINK_REGEX = "<\\s*a.*?href\\s*=\\s*\"\\s*(.+?)\\s*\".*?>\\s*(.+?)\\s*</a>";
    private static final Pattern LINK_PATTERN = Pattern.compile(LINK_REGEX);

    int linkCount = 0;
    int lineCount = 0;

    Scanner scanner = new Scanner(System.in);
    
    public void printf(String format, Object... args) {
        System.out.printf(format + "\n", args);
    }

    public static void main(String[] args) {
        new LinkExtractor().run();
    }

    public void run() {

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineCount++;

            Matcher linkMatcher = LINK_PATTERN.matcher(line);
            if (linkMatcher.find()) {
                linkCount++;

                String linkUrl = linkMatcher.group(1);

                if (linkUrl.equals(linkUrl.toLowerCase())) {
                    String linkText = linkMatcher.group(2);
                    printf("%s: %s, Anzahl Zeichen: %d", linkText, linkUrl, linkUrl.length());
                }
            }
        }

        printf("%d Links wurden in %d Zeilen gefunden", linkCount, lineCount);

        scanner.close();
    }
}
