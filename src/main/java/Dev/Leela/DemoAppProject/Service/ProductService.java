package Dev.Leela.DemoAppProject.Service;

import Dev.Leela.DemoAppProject.Client.FakeStoreClient;
import Dev.Leela.DemoAppProject.DTO.FakeStoreProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private FakeStoreClient fakeStoreClient;

    public FakeStoreProductDTO[] getProductsfromFakestore()
    {
        return fakeStoreClient.getAllProducts();
    }

    public FakeStoreProductDTO getProductbyIdfromFakestore(int id)
    {
        return fakeStoreClient.getProductbyId(id);
    }


}
