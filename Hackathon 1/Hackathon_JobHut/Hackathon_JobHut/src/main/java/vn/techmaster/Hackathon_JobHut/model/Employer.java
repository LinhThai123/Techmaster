package vn.techmaster.Hackathon_JobHut.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employer {
    private String id ;
    private String name ;
    private String website ;
    private String logo_path ;
    private String email ;
}
