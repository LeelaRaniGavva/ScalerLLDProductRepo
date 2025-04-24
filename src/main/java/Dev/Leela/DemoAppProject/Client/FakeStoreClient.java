package Dev.Leela.DemoAppProject.Client;

import Dev.Leela.DemoAppProject.DTO.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.*;

import java.util.Map;

@Component
public class FakeStoreClient {

    @Autowired
    private RestTemplate restTemplate;

    public FakeStoreProductDTO[] getAllProducts() {
        String productsURL = "https://fakestoreapi.com/products";
        return restTemplate.getForObject(productsURL, FakeStoreProductDTO[].class);
    }

    public FakeStoreProductDTO getProductbyId(int id) {
        String productURL = "https://fakestoreapi.com/products/" + id;
        return restTemplate.getForObject(productURL, FakeStoreProductDTO.class);
    }

    public FakeStoreProductDTO addingProduct(FakeStoreProductDTO input) {
        String URL = "https://fakestoreapi.com/products";
        return restTemplate.postForObject(URL, input, FakeStoreProductDTO.class);

    }


    public FakeStoreProductDTO updateProduct(FakeStoreProductDTO input, int id) {
        String URL = "https://fakestoreapi.com/products/" + id;
        return requestForObject(URL, HttpMethod.PUT, input, FakeStoreProductDTO.class);
    }

    /*private <T> T putForObject(String url, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, (Object[])uriVariables);
    }*/

    //making above method to generic
    private <T> T requestForObject(String url, HttpMethod httpMethod, @Nullable Object request, Class<T> responseType, Object... uriVariables) throws RestClientException {
        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor = new HttpMessageConverterExtractor(responseType, restTemplate.getMessageConverters());
        return restTemplate.execute(url, httpMethod, requestCallback, responseExtractor, (Object[]) uriVariables);
    }


    public boolean deleteProduct(int id) {
        String url = "https://fakestoreapi.com/products/" + id;
        try {
            requestForObject(url, HttpMethod.DELETE, null, FakeStoreProductDTO.class);
            return true;
        } catch (Exception exception) {
            System.out.println(exception);
            return false;

        }
    }
}
