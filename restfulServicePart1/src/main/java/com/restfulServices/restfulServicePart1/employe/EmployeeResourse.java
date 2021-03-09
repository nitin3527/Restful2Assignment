package com.restfulServices.restfulServicePart1.employe;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import io.swagger.annotations.ApiModelProperty;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
@RestController
public class EmployeeResourse {

    @Autowired
    private EmployeeDaoService service;

    @GetMapping(path = "/employees")
    @ApiModelProperty(notes = "All employees details")
    public List<Employee> getAllEmp(){
        return service.findAll();
    }

    @GetMapping(path = "/employees/{id}")
    @ApiModelProperty(notes = "employee detail")
    public EntityModel<Employee> getEmp(@PathVariable int id){
        Employee emp =  service.findOne(id);
        if(emp == null) throw new EmployeeNotFoundException("id- " + id);

        EntityModel<Employee> resource = EntityModel.of(emp);
        WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).getAllEmp());
        resource.add(linkTo.withRel("all-employees"));
        return resource;
    }
    @DeleteMapping(path = "/employees/{id}")
    @ApiModelProperty(notes = "Delete employee")
    public void deleteEmp(@PathVariable int id){
        Employee emp =  service.delete(id);
        if(emp.getId() == null) throw new EmployeeNotFoundException("id- " + id);
    }
    @PutMapping("/employees")
    @ApiModelProperty(notes = "update employee details")
    public ResponseEntity<Object> updateEmployee(@Valid @RequestBody Employee employee) throws EmployeeNotFoundException {
        Employee employee1 = service.updateEmployeeDetails(employee);
        if (employee1 == null)
            throw new EmployeeNotFoundException("Incorrect id");
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{id}")
                .buildAndExpand(employee1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }

    @PostMapping("/employees")
    @ApiModelProperty(notes = "create employee")
    public ResponseEntity<Object> getEmp(@Valid @RequestBody Employee emp){
        Employee emp1 =  service.saveEmployee(emp);
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(emp1.getId()).toUri();
        return ResponseEntity.created(location).build();
    }
}
/*
    @GetMapping("/name/{customerName}")
    public EntityModel<Customer> getCustomerByName(@PathVariable String customerName) {
        Customer customer = customerService.getByName(customerName);

        EntityModel<Customer> resource = new EntityModel<>(customer);
        Link linkTo = linkTo(methodOn(getClass()).getCustomerById(customer.getId())).withRel("user-by-id");
        resource.add(linkTo);
        return resource;
    }
    @Bean
    public LinkDiscoverers discoverers() {
        List<LinkDiscoverer> plugins = new ArrayList<>();
        plugins.add(new CollectionJsonLinkDiscoverer());
        return new LinkDiscoverers(SimplePluginRegistry.create(plugins));

    }

 */