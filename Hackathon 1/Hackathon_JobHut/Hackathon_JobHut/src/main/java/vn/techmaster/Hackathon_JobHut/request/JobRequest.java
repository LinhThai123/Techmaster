package vn.techmaster.Hackathon_JobHut.request;

import vn.techmaster.Hackathon_JobHut.model.City;

public record JobRequest (String id , String emp_id ,String employer , String title , String description , City city){
}
