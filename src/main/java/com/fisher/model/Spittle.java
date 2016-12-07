package com.fisher.model;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "spittle")
@NamedQueries(value = {
        @NamedQuery(name = "spittle.findSpittles", query = "select spittle from Spittle spittle where spittle.id < :max order by spittle.time desc")
})
public class Spittle {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String message;
  @Column(name = "created_at")
  private Date time;
  private Double latitude;
  private Double longitude;

  public Spittle() {}
  
  public Spittle(Long id, String message, Date time, Double longitude, Double latitude) {
    this.id = id;
    this.message = message;
    this.time = time;
    this.longitude = longitude;
    this.latitude = latitude;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public void setTime(Date time) {
    this.time = time;
  }

  public void setLatitude(Double latitude) {
    this.latitude = latitude;
  }

  public void setLongitude(Double longitude) {
    this.longitude = longitude;
  }

  public long getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }

  public Date getTime() {
    return time;
  }
  
  public Double getLongitude() {
    return longitude;
  }
  
  public Double getLatitude() {
    return latitude;
  }

  @Override
  public String toString() {
    return "Spittle{" +
            "id=" + id +
            ", message='" + message + '\'' +
            ", time=" + time +
            ", latitude=" + latitude +
            ", longitude=" + longitude +
            '}';
  }
}
