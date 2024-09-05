package com.myapp.usecase.asset.create

import com.myapp.usecase.Asset
import com.myapp.usecase.AssetResponse
import com.myapp.usecase.MockMvcTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.http.HttpStatus

import static com.myapp.usecase.asset.AssetType.IMAGE

class CreateAssetControllerTest extends MockMvcTest {

    private CreateAssetRepository repository = Mock()
    private JacksonTester<AssetResponse> assetResponseMapper
    private JacksonTester<CreateAssetRequest> createAssetRequestMapper

    def setup() {
        def controller = new CreateAssetController(repository, modelMapper)
        setupMvc(controller)
    }

    def "should create asset"() {
        given:
        def expectedAsset = createAsset()
        def assetRequest = createAssetRequest()
        def jsonAssetRequest = createAssetRequestMapper.write(assetRequest).getJson()
        repository.create(_ as NewAsset) >> expectedAsset

        when:
        def response = post("/assets", jsonAssetRequest)
        def createdAsset = assetResponseMapper.parseObject(response.contentAsString)

        then:
        response.status == HttpStatus.CREATED.value()
        assertAsset(createdAsset, expectedAsset)
    }

    private static void assertAsset(AssetResponse actualAsset, Asset expectedAsset) {
        assert actualAsset.id == expectedAsset.id
        assert actualAsset.name == expectedAsset.name
        assert actualAsset.description == expectedAsset.description.get()
        assert actualAsset.type == expectedAsset.type
    }

    private static CreateAssetRequest createAssetRequest() {
        return new CreateAssetRequest(
                "Asset name",
                "Asset description",
                IMAGE
        )
    }

    private static Asset createAsset() {
        return Asset.builder()
                .id(1L)
                .name("Asset name")
                .description("Asset description")
                .type(IMAGE)
                .build()
    }
}
