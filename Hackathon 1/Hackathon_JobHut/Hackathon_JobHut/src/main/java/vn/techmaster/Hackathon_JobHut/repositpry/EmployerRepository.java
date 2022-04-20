package vn.techmaster.Hackathon_JobHut.repositpry;

import org.springframework.stereotype.Repository;
import vn.techmaster.Hackathon_JobHut.model.Employer;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class EmployerRepository {
    private ConcurrentHashMap<String , Employer> employers = new ConcurrentHashMap<>() ;

    public EmployerRepository () {}

    public Map<String,String> getMapNameId() {
        Map<String,String>mapEmp = new HashMap<>();
        List<Employer> listEmp = new ArrayList<>(employers.values().stream().toList());
        for(Employer e :listEmp){
            mapEmp.put(e.getName(),e.getId());
        }
        return mapEmp;
    }
    // Cần sinh ra UUID chp Employer
    public Employer add (Employer employer) {
        String id = UUID.randomUUID().toString() ;
        employer.setId(id);
        employers.put(id , employer) ;
        return employer ;
    }
    // Lấy ra dữ liệu cảu Employer
    public Collection<Employer> getAll() {
        return employers.values() ;
    }
    // Tìm kiếm Employer theo id
    public Employer findById (String id) {
        return employers.get(id) ;
    }

    // thêm các trường dữ liệu
    @PostConstruct // Đc thực thi ngay sau khi Soring bean đc khởi tạo
    public void addData () {
        this.add(Employer.builder().name("FPT")
                .website("https://fpt.com.vn").logo_path("fpt.png")
                .email("hr@fpt.com").build()) ;
        this.add(Employer.builder().name("CMC")
                .website("https://cmc.com.vn").logo_path("cmc.jpg")
                .email("hrcmc@gmail.com").build());
        this.add(Employer.builder().name("Amazon")
                .website("https://amazon.com.vn").logo_path("amazon.png")
                .email("hr@amazon.com").build());
        this.add(Employer.builder().name("Google")
                .website("https://google.com.vn").logo_path("google.png")
                .email("hr@google.com").build());
    }
    // Cập nhật logo của Employer
    public void updateLogoPath (String id , String logo_path) {
         var emp = employers.get(id) ;
         emp.setLogo_path(logo_path);
         employers.put(id , emp) ;
    }
}
