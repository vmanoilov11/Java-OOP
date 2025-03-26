import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Smartphone implements Browsable, Callable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = new ArrayList<>(numbers);
        this.urls = new ArrayList<>(urls);
    }

    @Override
    public String browse() {
        return urls.stream()
                .map(url -> url.matches("^\\D+$") ? "Browsing: " + url + "!" : "Invalid URL!")
                .collect(Collectors.joining(System.lineSeparator()));
    }

    @Override
    public String call() {
        return numbers.stream()
                .map(number -> number.matches("^\\d+$") ? "Calling... " + number : "Invalid number!")
                .collect(Collectors.joining(System.lineSeparator()));
    }
}
