package vn.techmaster.job.controller;

import org.springframework.web.bind.annotation.*;
import vn.techmaster.job.Location;
import vn.techmaster.job.dto.JobRequest;
import vn.techmaster.job.model.Job;

import java.util.Comparator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/job")
public class JobController {
    private ConcurrentHashMap<String, Job> jobs;


    public JobController() {
        jobs = new ConcurrentHashMap<String, Job>();
        jobs.put("01", new Job("01", "dev spring", "LTV Spring", Location.NgheAn, 100000, 800000, "uio123@gmail.com"));
        jobs.put("02", new Job("02", "dev java", "LTV Java", Location.HaNoi, 200000, 900000, "abc@gmail.com"));
        jobs.put("03", new Job("03", "dev c++", "LTV C++", Location.HaiPhong, 300000, 1000000, "jkl123@gmail.com"));
        jobs.put("04", new Job("04", "dev php", "LTV PHP", Location.NamDinh, 100000, 7000000, "sdf123@gmail.com"));
    }

    @GetMapping
    public List<Job> getJob() {
        return jobs.values().stream()
                .sorted(Comparator.comparing(Job::getMin_salary))
                .collect(Collectors.toList());
    }
    @PostMapping
    public Job createNewBook(@RequestBody JobRequest jobRequest) {
        String uuid = UUID.randomUUID().toString();
        Job newJob = new Job(uuid, jobRequest.title(), jobRequest.description(), jobRequest.location(),
                jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email_to());
        jobs.put(uuid, newJob);
        return newJob;
    }
    @GetMapping(value = "/{id}")
    public Job getJobById(@PathVariable("id") String id) {
        return jobs.get(id);
    }

    @PutMapping(value = "/{id}")
    public Job updateJobById(@PathVariable("id") String id, @RequestBody JobRequest jobRequest) {
        Job updateJob = new Job(id, jobRequest.title(), jobRequest.description(), jobRequest.location(),
                jobRequest.min_salary(), jobRequest.max_salary(), jobRequest.email_to());
        jobs.replace(id, updateJob);
        return updateJob;
    }

    @DeleteMapping(value = "/{id}")
    public Job deleteBookById(@PathVariable("id") String id) {
        Job removedJob = jobs.remove(id);
        return removedJob;
    }
    // job/sortbylocation: sắp xếp danh sách job theo thành phố tuyển
    @GetMapping(value = "/sortbylocation")
    public List<Job> sortByLocation() {
        return jobs.values().stream().sorted(Comparator.comparing(Job::getLocation)).collect(Collectors.toList());
    }
    //tìm các job mà {salary} trong khoảng min_salary và max_salary
    @GetMapping(value = "/salary/{salary}")
    public List<Job> getBySalary(@PathVariable("salary") long salary) {
        return jobs.values().stream().filter(luong -> ((luong.getMin_salary() <= (salary)) && (luong.getMax_salary() >= (salary))))
                .collect(Collectors.toList());
    }
    // tìm các job mà title hoặc description chứa {keyword}
    @GetMapping(value = "/keyword/{keyword}")
    public List<Job> getByKeyWord(@PathVariable("keyword") String keyword) {

        return jobs.values().stream().filter(k -> (k.getTitle().toLowerCase().contains(keyword.toLowerCase())
                || k.getDescription().toLowerCase().contains(keyword.toLowerCase()))).collect(Collectors.toList());
    }
    //tìm các job mà title hoặc description chứa {keyword} đồng thời location ={location}
    @GetMapping(value = "/query")
    public List<Job> getListByQuery(@RequestParam("location") Location location,
                                                 @RequestParam("keyword") String keyword) {
        return jobs.values().stream().filter(n -> ((n.getTitle().contains(keyword)
                || n.getDescription().contains(keyword)) && (n.getLocation().equals(location)))).collect(Collectors.toList());
    }
}
