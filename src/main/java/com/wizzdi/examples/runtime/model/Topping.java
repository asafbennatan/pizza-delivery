package com.wizzdi.examples.runtime.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Topping extends Basic {

  @OneToMany(targetEntity = PizzaToTopping.class, mappedBy = "topping")
  @JsonIgnore
  private List<PizzaToTopping> toppingToppingToPizzas;

  private double price;

  /**
   * @return toppingToppingToPizzas
   */
  @OneToMany(targetEntity = PizzaToTopping.class, mappedBy = "topping")
  @JsonIgnore
  public List<PizzaToTopping> getToppingToppingToPizzas() {
    return this.toppingToppingToPizzas;
  }

  /**
   * @param toppingToppingToPizzas toppingToppingToPizzas to set
   * @return Topping
   */
  public <T extends Topping> T setToppingToppingToPizzas(
      List<PizzaToTopping> toppingToppingToPizzas) {
    this.toppingToppingToPizzas = toppingToppingToPizzas;
    return (T) this;
  }

  /**
   * @return price
   */
  public double getPrice() {
    return this.price;
  }

  /**
   * @param price price to set
   * @return Topping
   */
  public <T extends Topping> T setPrice(double price) {
    this.price = price;
    return (T) this;
  }
}
