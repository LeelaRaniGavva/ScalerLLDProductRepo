package Dev.Leela.DemoAppProject.Client;

import Dev.Leela.DemoAppProject.DTO.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplate restTemplate;

    public FakeStoreProductDTO[] getAllProducts()
    {
        String productsURL="https://fakestoreapi.com/products";
        return restTemplate.getForObject(productsURL,FakeStoreProductDTO[].class);
    }
    public FakeStoreProductDTO getProductbyId(int id)
    {
        String productURL="https://fakestoreapi.com/products/"+id;
        return restTemplate.getForObject(productURL, FakeStoreProductDTO.class);
    }


}
