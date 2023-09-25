package dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class User {
    private String username;
    private String lastName;
    private String email;
    private String password;
}
