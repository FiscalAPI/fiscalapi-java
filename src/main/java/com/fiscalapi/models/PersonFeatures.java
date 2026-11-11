package com.fiscalapi.models;

import com.fiscalapi.common.SerializableDto;

import java.util.List;
import java.util.Map;

/**
 * Lo que la persona puede hacer ({@link MeInfo#getFeatures()}). Es informativo: cada endpoint vuelve a evaluar su
 * permiso.
 */
public class PersonFeatures extends SerializableDto {

    private Boolean isOwner;
    private List<String> roles;
    private List<String> permissions;
    private Map<String, DeniedPermission> denied;
    private Map<String, PersonFeature> features;
    private PersonSubscription subscription;
    private List<PersonSeatAssignment> seatAssignments;

    /**
     * @return true si la persona es el owner del tenant
     */
    public Boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(Boolean isOwner) {
        this.isOwner = isOwner;
    }

    /**
     * @return Roles de la persona: Owner o Member (más Host para la persona del host)
     */
    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    /**
     * @return Permisos concedidos, con la forma Área.Acción (por ejemplo, Invoices.Issue)
     */
    public List<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<String> permissions) {
        this.permissions = permissions;
    }

    /**
     * @return Permisos que el rol de la persona tiene pero se le niegan porque al tenant le faltan features, por permiso
     */
    public Map<String, DeniedPermission> getDenied() {
        return denied;
    }

    public void setDenied(Map<String, DeniedPermission> denied) {
        this.denied = denied;
    }

    /**
     * @return Features habilitados del tenant, por código (por ejemplo, emision_cfdi), con sus valores
     */
    public Map<String, PersonFeature> getFeatures() {
        return features;
    }

    public void setFeatures(Map<String, PersonFeature> features) {
        this.features = features;
    }

    /**
     * @return La suscripción que otorga los features del tenant
     */
    public PersonSubscription getSubscription() {
        return subscription;
    }

    public void setSubscription(PersonSubscription subscription) {
        this.subscription = subscription;
    }

    /**
     * @return Los asientos de la persona en los features por persona; vacío si no tiene ninguno
     */
    public List<PersonSeatAssignment> getSeatAssignments() {
        return seatAssignments;
    }

    public void setSeatAssignments(List<PersonSeatAssignment> seatAssignments) {
        this.seatAssignments = seatAssignments;
    }
}
