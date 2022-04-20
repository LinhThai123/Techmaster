package vn.techmaster.Hackathon_JobHut.repositpry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.techmaster.Hackathon_JobHut.model.City;
import vn.techmaster.Hackathon_JobHut.model.Job;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class JobRepository {
    private ConcurrentHashMap<String, Job> jobs = new ConcurrentHashMap<>();

    @Autowired EmployerRepository employerRepository ;

    public Collection<Job> getAll(){
        for (Job j:jobs.values().stream().toList()){
            for(Map.Entry<String,String>emp : employerRepository.getMapNameId().entrySet()){
                if(j.getEmployer()==emp.getKey()){
                    j.setEmp_id(emp.getValue());
                }
            }
        }
        return jobs.values();
    }
    public List<String> getIdJobs(){
        return jobs.keySet().stream().toList();
    }

    public Job addJob(Job job) {
        String id = UUID.randomUUID().toString();
        job.setId(id);
        jobs.put(id, job);
        return job;
    }

    public Job findById(String id) {
        return jobs.get(id);
    }

    public Job deleteById(String id) {
        return jobs.remove(id);
    }

    public void update(Job job){
        jobs.put(job.getId(), job);
    }
    // Thêm dữ liệu vào job
    @PostConstruct
    public void addJob () {
        this.addJob(Job.builder()
                // .emp_id(listEmpId().get(0))
                .employer("FPT")
                .title("Tuyển Fresh")
                .description("Tuyển Fresh fullStack lương 1000 usb,yêu cầu tốt nghiệp techmaster")
                .city(City.DaNang).build());

        this.addJob(Job.builder()
                // .emp_id(listEmpId().get(1))
                .employer("CMC")
                .title("Tuyển Thực Tập Sinh")
                .description("Tuyển Thực tập sinh Backend Java lương 1000 usb,yêu cầu tốt nghiệp techmaster")
                .city(City.HaNoi).build());

        this.addJob(Job.builder()
                // .emp_id(listEmpId().get(2))
                .employer("Amazon")
                .title("Tuyển FrontEnd")
                .description("Tuyển FrontEnd lương 1000 usb,yêu cầu tốt nghiệp techmaster")
                .city(City.HaiPhong).build());

        this.addJob(Job.builder()
                // .emp_id(listEmpId().get(3))
                .employer("Google")
                .title("Tuyển Junior")
                .description("Tuyển Jonior,Thao thạo 2 ngoại ngữ,làm chủ được SpringBoot")
                .city(City.HoChiMinh).build());
    }

}
