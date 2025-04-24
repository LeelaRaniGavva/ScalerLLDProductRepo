package Dev.Leela.DemoAppProject.Controller;

import Dev.Leela.DemoAppProject.DTO.FakeStoreProductDTO;
import Dev.Leela.DemoAppProject.Service.ProductService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<FakeStoreProductDTO> getAllProducts(@PathVariable("id") int id)
    {
        if(id<=0) {
            throw new IllegalArgumentException("Product doesn't exist");
            //return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
        FakeStoreProductDTO fakeStoreProductDTO= productService.getProductbyIdfromFakestore(id);
        return new ResponseEntity<>(fakeStoreProductDTO, HttpStatus.OK);
    }

    @ExceptionHandler({IllegalArgumentException.class,NullPointerException.class})
    public ResponseEntity<String> handleException(Exception exception)
    {
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
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
