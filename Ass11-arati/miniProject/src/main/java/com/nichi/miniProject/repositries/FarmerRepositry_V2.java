package com.nichi.miniProject.repositries;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nichi.miniProject.model.Farmer;


@Repository
public interface FarmerRepositry_V2 extends JpaRepository<Farmer, Integer> {

    //@Modifying
   // @Query(value="SELECT FROM Farmer f where f.fname=:fname", nativeQuery = true)
    
    //void searchByfname(String fname);


    @Query(value="SELECT farmer_Id,fname,age FROM Farmer f where f.fname=:fname", nativeQuery = true)
    public List<Farmer> searchByfname(String fname);


    // no need for id .. void deleteById(int fId);


///new

//@Query("SELECT farmer.id,farmer.name,farmer.age FROM FARMER")
 //public List<Farmer> search(String keyword);

//@Query("SELECT farmer.id,farmer.name,farmer.age FROM Farmer farmer WHERE CONCAT(farmer.name,farmer.age)LIKE%?1% ")
//public List<Farmer> search(String keyword);



 ///
 //public Farmer findByName(String name);





   // @Query("SELECT fname,age FROM FARMER WHERE fname=%s")

   // 

   // public Farmer findByName(String name);

    /* 
    void deleteByfname(String fname);

    @Modifying
    @Query(value="DELETE FROM Farmer f where f.age=:age", nativeQuery = true)
    public int deleteByAge(int age);
*/
}