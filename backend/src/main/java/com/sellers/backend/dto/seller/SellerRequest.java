package com.sellers.backend.dto.seller;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public class SellerRequest {
  @NotBlank(message = "Seller name is mandatory")
  @Size(min = 2, max = 255, message = "Name must be between 2 and 255 characters")
  private String name;

  @PositiveOrZero(message = "Salary must be greater than or equal to zero")
  private double salary;

  @DecimalMin(value = "0.0", message = "Bonus cannot be negative")
  @DecimalMax(value = "100.0", message = "Bonus cannot exceed 100")
  private double bonus;

  @Min(value = 0, message = "Gender value must be 0 (Male) or 1 (Female)")
  @Max(value = 1, message = "Gender value must be 0 (Male) or 1 (Female)")
  private int gender;

  public SellerRequest() {
  }

  public SellerRequest(String name, double salary, double bonus, int gender) {
    this.name = name;
    this.salary = salary;
    this.bonus = bonus;
    this.gender = gender;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getSalary() {
    return salary;
  }

  public void setSalary(double salary) {
    this.salary = salary;
  }

  public double getBonus() {
    return bonus;
  }

  public void setBonus(double bonus) {
    this.bonus = bonus;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }
}
