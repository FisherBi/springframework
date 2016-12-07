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

  
}
