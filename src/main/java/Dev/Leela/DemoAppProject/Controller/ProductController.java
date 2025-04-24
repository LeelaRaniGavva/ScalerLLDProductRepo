package Dev.Leela.DemoAppProject.Controller;

import Dev.Leela.DemoAppProject.DTO.FakeStoreProductDTO;
import Dev.Leela.DemoAppProject.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/products")
    public FakeStoreProductDTO addProduct(@RequestBody FakeStoreProductDTO input)
    {
        return productService.addProducttoRepo(input);

    }

    @PutMapping("/products/{id}")
    public FakeStoreProductDTO updateProduct(@RequestBody FakeStoreProductDTO fakeStoreProductDTO,@PathVariable int id)
    {
        return productService.updateProduct(fakeStoreProductDTO,id);
    }
    @DeleteMapping("/products/{id}")
    public boolean deleteProductbyId(@PathVariable("id") int id)
    {
        return productService.deleteProduct(id);
    }



}
