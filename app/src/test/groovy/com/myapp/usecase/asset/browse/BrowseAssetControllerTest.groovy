package com.myapp.usecase.asset.browse

import com.myapp.usecase.Asset
import com.myapp.usecase.AssetRepository
import com.myapp.usecase.AssetResponse
import com.myapp.usecase.MockMvcTest
import org.springframework.boot.test.json.JacksonTester
import org.springframework.http.HttpStatus

import static com.myapp.usecase.asset.AssetType.IMAGE

class BrowseAssetControllerTest extends MockMvcTest {

    private AssetRepository repository = Mock()
    private JacksonTester<AssetResponse> assetResponseMapper
    private JacksonTester<List<AssetResponse>> assetsResponseMapper

    def setup() {
        def controller = new BrowseAssetController(repository, modelMapper)
        setupMvc(controller)
    }

    def "should find asset"() {
        given:
        def expectedAsset = createAsset()
        repository.find(expectedAsset.id) >> Optional.of(expectedAsset)

        when:
        def response = get("/assets/" + expectedAsset.id)
        def actualAsset = assetResponseMapper.parseObject(response.contentAsString)

        then:
        response.status == HttpStatus.OK.value()
        assertAsset(actualAsset, expectedAsset)
    }

    def "should find all assets"() {
        given:
        def expectedAsset = createAsset()
        repository.findAll() >> List.of(expectedAsset)

        when:
        def response = get("/assets")
        def actualAssets = assetsResponseMapper.parseObject(response.contentAsString)

        then:
        response.status == HttpStatus.OK.value()
        assert actualAssets.size() == 1
        def actualAsset = actualAssets.first()
        assertAsset(actualAsset, expectedAsset)
    }

    private static void assertAsset(AssetResponse actualAsset, Asset expectedAsset) {
        assert actualAsset.id == expectedAsset.id
        assert actualAsset.name == expectedAsset.name
        assert actualAsset.description == expectedAsset.description
        assert actualAsset.type == expectedAsset.type
    }

    private static Asset createAsset() {
        return Asset.builder()
                .id(1L)
                .name("Asset name")
                .description("Asset description")
                .type(IMAGE)
                .build();
    }
}
