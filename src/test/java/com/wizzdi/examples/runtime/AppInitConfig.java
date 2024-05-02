package com.wizzdi.examples.runtime;

import com.wizzdi.examples.runtime.model.Branch;
import com.wizzdi.examples.runtime.model.Pizza;
import com.wizzdi.examples.runtime.model.PizzaOrder;
import com.wizzdi.examples.runtime.model.Topping;
import com.wizzdi.examples.runtime.request.AppUserCreate;
import com.wizzdi.examples.runtime.request.BranchCreate;
import com.wizzdi.examples.runtime.request.PizzaCreate;
import com.wizzdi.examples.runtime.request.PizzaOrderCreate;
import com.wizzdi.examples.runtime.request.ToppingCreate;
import com.wizzdi.examples.runtime.security.UserSecurityContext;
import com.wizzdi.examples.runtime.service.AppUserService;
import com.wizzdi.examples.runtime.service.BranchService;
import com.wizzdi.examples.runtime.service.PizzaOrderService;
import com.wizzdi.examples.runtime.service.PizzaService;
import com.wizzdi.examples.runtime.service.ToppingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppInitConfig {

  @Autowired private BranchService branchService;

  @Autowired private PizzaOrderService pizzaOrderService;

  @Autowired private PizzaService pizzaService;

  @Autowired private ToppingService toppingService;

  @Autowired
  @Qualifier("adminSecurityContext")
  private UserSecurityContext securityContext;

  @Bean
  public Branch branch() {
    BranchCreate branchCreate = new BranchCreate();
    return branchService.createBranch(branchCreate, securityContext);
  }

  @Bean
  public PizzaOrder pizzaOrder() {
    PizzaOrderCreate pizzaOrderCreate = new PizzaOrderCreate();
    return pizzaOrderService.createPizzaOrder(pizzaOrderCreate, securityContext);
  }

  @Bean
  public Pizza pizza() {
    PizzaCreate pizzaCreate = new PizzaCreate();
    return pizzaService.createPizza(pizzaCreate, securityContext);
  }

  @Bean
  public Topping topping() {
    ToppingCreate toppingCreate = new ToppingCreate();
    return toppingService.createTopping(toppingCreate, securityContext);
  }

  @Configuration
  public static class UserConfig {
    @Bean
    @Qualifier("adminSecurityContext")
    public UserSecurityContext adminSecurityContext(AppUserService appUserService) {
      com.wizzdi.examples.runtime.model.AppUser admin =
          appUserService.createAppUser(
              new AppUserCreate().setUsername("admin@flexicore.com").setPassword("admin"), null);
      return new UserSecurityContext(admin);
    }
  }
}
