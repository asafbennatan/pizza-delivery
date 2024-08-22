package com.wizzdi.examples.model.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Pizza extends SecuredBasic {

  @OneToMany(targetEntity = PizzaToTopping.class, mappedBy = "pizza")
  @JsonIgnore
  private List<PizzaToTopping> pizzaToppingToPizzas;

  @ManyToOne(targetEntity = PizzaOrder.class)
  private PizzaOrder pizzaOrder;

  /**
   * @return pizzaToppingToPizzas
   */
  @OneToMany(targetEntity = PizzaToTopping.class, mappedBy = "pizza")
  @JsonIgnore
  public List<PizzaToTopping> getPizzaToppingToPizzas() {
    return this.pizzaToppingToPizzas;
  }

  /**
   * @param pizzaToppingToPizzas pizzaToppingToPizzas to set
   * @return Pizza
   */
  public <T extends Pizza> T setPizzaToppingToPizzas(List<PizzaToTopping> pizzaToppingToPizzas) {
    this.pizzaToppingToPizzas = pizzaToppingToPizzas;
    return (T) this;
  }

  /**
   * @return pizzaOrder
   */
  @ManyToOne(targetEntity = PizzaOrder.class)
  public PizzaOrder getPizzaOrder() {
    return this.pizzaOrder;
  }

  /**
   * @param pizzaOrder pizzaOrder to set
   * @return Pizza
   */
  public <T extends Pizza> T setPizzaOrder(PizzaOrder pizzaOrder) {
    this.pizzaOrder = pizzaOrder;
    return (T) this;
  }
}
