package com.fisher.exception;

public class SpittleNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;
  
  private long spittleId;

  public SpittleNotFoundException(long spittleId) {
    this.spittleId = spittleId;
  }
  
  public long getSpittleId() {
    return spittleId;
  }
  
}
