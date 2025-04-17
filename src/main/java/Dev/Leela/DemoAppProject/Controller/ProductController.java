package Dev.Leela.DemoAppProject.Controller;

import Dev.Leela.DemoAppProject.DTO.FakeStoreProductDTO;
import Dev.Leela.DemoAppProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController
{
    @Autowired
    private ProductService productService;

    @GetMapping("/products")
    public FakeStoreProductDTO[] getAllProducts()
    {
        return productService.getProductsfromFakestore();
    }

    @GetMapping("/products/{id}")
    public FakeStoreProductDTO getAllProducts(@PathVariable("id") int id)
    {
        return productService.getProductbyIdfromFakestore(id);
    }




}
