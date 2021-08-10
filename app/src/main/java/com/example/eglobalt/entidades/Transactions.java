package com.example.eglobalt.entidades;

import java.sql.Timestamp;

public class Transactions {
    private Integer id;
    private String amount;
    private String status;
    private String status_descriptions;
    private Integer service_id;
    private Integer Service_request_id;
    private Integer atm_id;
    private Timestamp created_at;
    private Integer owner_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatus_descriptions() {
        return status_descriptions;
    }

    public void setStatus_descriptions(String status_descriptions) {
        this.status_descriptions = status_descriptions;
    }

    public Integer getService_id() {
        return service_id;
    }

    public void setService_id(Integer service_id) {
        this.service_id = service_id;
    }

    public Integer getService_request_id() {
        return Service_request_id;
    }

    public void setService_request_id(Integer service_request_id) {
        Service_request_id = service_request_id;
    }

    public Integer getAtm_id() {
        return atm_id;
    }

    public void setAtm_id(Integer atm_id) {
        this.atm_id = atm_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public Integer getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Integer owner_id) {
        this.owner_id = owner_id;
    }
}
