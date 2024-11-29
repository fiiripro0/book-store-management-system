package com.LibraryMS.service;

import com.LibraryMS.entity.Libraries;
import com.LibraryMS.repository.LibrariesRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibrariesService {
    private  LibrariesRepository lrepo;
    public LibrariesService(LibrariesRepository lrepo){
        this.lrepo=lrepo;

    }
    public  void  insertLib(Libraries lib){
        lrepo.save(lib);
    }
    public void  updateLip(Libraries lib){
        lrepo.save(lib);
    }
    public  void delLibById(int id){
        lrepo.deleteById(id);
    }
    public Libraries getLibById(int id ){
        return  lrepo.findById(id).orElse(null);
    }

    public List<Libraries> getAllLib(){
        return lrepo.findAll();
    }

}
