package com.wizzdi.examples.model;

import com.wizzdi.examples.model.model.Branch;
import com.wizzdi.examples.model.model.Pizza;
import com.wizzdi.examples.model.model.PizzaOrder;
import com.wizzdi.examples.model.model.Topping;
import com.wizzdi.examples.model.request.AppUserCreate;
import com.wizzdi.examples.model.request.BranchCreate;
import com.wizzdi.examples.model.request.PizzaCreate;
import com.wizzdi.examples.model.request.PizzaOrderCreate;
import com.wizzdi.examples.model.request.ToppingCreate;
import com.wizzdi.examples.model.security.UserSecurityContext;
import com.wizzdi.examples.model.service.AppUser1Service;
import com.wizzdi.examples.model.service.BranchService;
import com.wizzdi.examples.model.service.PizzaOrderService;
import com.wizzdi.examples.model.service.PizzaService;
import com.wizzdi.examples.model.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppInitConfig {

  @Autowired private ToppingService toppingService;

  @Autowired private PizzaService pizzaService;

  @Autowired private PizzaOrderService pizzaOrderService;

  @Autowired private BranchService branchService;

  @Autowired
  @Qualifier("adminSecurityContext")
  private UserSecurityContext securityContext;

  @Bean
  public Topping topping() {
    ToppingCreate toppingCreate = new ToppingCreate();
    return toppingService.createTopping(toppingCreate, securityContext);
  }

  @Bean
  public Pizza pizza() {
    PizzaCreate pizzaCreate = new PizzaCreate();
    return pizzaService.createPizza(pizzaCreate, securityContext);
  }

  @Bean
  public PizzaOrder pizzaOrder() {
    PizzaOrderCreate pizzaOrderCreate = new PizzaOrderCreate();
    return pizzaOrderService.createPizzaOrder(pizzaOrderCreate, securityContext);
  }

  @Bean
  public Branch branch() {
    BranchCreate branchCreate = new BranchCreate();
    return branchService.createBranch(branchCreate, securityContext);
  }

  @Configuration
  public static class UserConfig {
    @Bean
    @Qualifier("adminSecurityContext")
    public UserSecurityContext adminSecurityContext(AppUser1Service appUser1Service) {
      com.wizzdi.examples.model.model.AppUser admin =
          appUser1Service.createAppUser(
              new AppUserCreate().setUsername("admin@flexicore.com").setPassword("admin"), null);
      return new UserSecurityContext(admin);
    }
  }
}
