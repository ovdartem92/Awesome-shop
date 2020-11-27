package model;
import lombok.*;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class Flights {
    @NonNull
    private String cityTo;
    @NonNull
    private String cityFrom;
    @NonNull
    private String date;
    private String departDay;
    private String returnDay;
}
