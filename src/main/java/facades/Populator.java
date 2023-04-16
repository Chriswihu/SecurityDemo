/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import dtos.HobbyDTO;
import dtos.PersonDTO;
import dtos.RenameMeDTO;
import entities.Hobby;
import entities.Person;
import entities.RenameMe;
import javax.persistence.EntityManagerFactory;
import utils.EMF_Creator;

/**
 *
 * @author tha
 */
public class Populator {
    public static void populate(){
        EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory();
        PersonFacade pf = PersonFacade.getPersonFacade(emf);
        PersonDTO p1 = new PersonDTO(new Person("Kurt", 45));
        PersonDTO p2 = new PersonDTO(new Person("Hanne", 35));
        PersonDTO p3 = new PersonDTO(new Person("Ib", 25));
        p1 = pf.create(p1);
        p2 = pf.create(p2);
        p3 = pf.create(p3);


        HobbyDTO hdto1 = new HobbyDTO(new Hobby("Fodbold", "Spiller fodbold"));
        HobbyDTO hdto2 = new HobbyDTO(new Hobby("Håndbold", "Spiller håndbold"));
        hdto1 = pf.createHobby(hdto1);
        hdto2 = pf.createHobby(hdto2);
        pf.addHobby(p1.getId(), hdto1.getId());
        pf.addHobby(p1.getId(), hdto2.getId());
        pf.addHobby(p2.getId(), hdto2.getId());
        pf.addHobby(p3.getId(), hdto2.getId());

//        pf.removeHobbyFromPerson(p1.getId(), hdto1.getId());

    }
    
    public static void main(String[] args) {
        populate();
    }
}
