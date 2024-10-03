package com.devsuperior.aula.services;

import com.devsuperior.aula.dto.PersonDTO;
import com.devsuperior.aula.dto.PersonDepartmentDTO;
import com.devsuperior.aula.entities.Department;
import com.devsuperior.aula.entities.Person;
import com.devsuperior.aula.repositories.DepartmentRepository;
import com.devsuperior.aula.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    //POST utilizando PersonDepartmentDTO e DepartmentDTO
    @Transactional
    public PersonDepartmentDTO insert(PersonDepartmentDTO dto) {
        Person entityPerson = new Person();
        entityPerson.setName(dto.getName());
        entityPerson.setSalary(dto.getSalary());
        Department entityDepartment = departmentRepository.getReferenceById(dto.getDepartment().getId());
        entityPerson.setDepartment(entityDepartment);
        entityPerson = personRepository.save(entityPerson);
        return new PersonDepartmentDTO(entityPerson);
    }

    //POST utilizando PersonDTO
    @Transactional
    public PersonDTO insert(PersonDTO dto) {
        Person entityPerson = new Person();
        entityPerson.setName(dto.getName());
        entityPerson.setSalary(dto.getSalary());
        Department entityDepartment = departmentRepository.getReferenceById(dto.getDepartmentId());
        entityPerson.setDepartment(entityDepartment);
        entityPerson = personRepository.save(entityPerson);
        return new PersonDTO(entityPerson);
    }
}

