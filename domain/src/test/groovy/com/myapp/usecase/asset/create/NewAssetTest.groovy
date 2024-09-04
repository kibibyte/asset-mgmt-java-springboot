package com.myapp.usecase.asset.create

import com.myapp.exceptions.InvalidArgumentException
import spock.lang.Specification

import static com.myapp.usecase.asset.AssetType.IMAGE
import static com.myapp.usecase.asset.AssetType.VIDEO

class NewAssetTest extends Specification {

    private static final String INVALID_ARGUMENT_MESSAGE = "Invalid argument"

    def "should consider asset as valid"() {
        when:
        new NewAsset(name, description, type)

        then:
        noExceptionThrown()

        where:
        name   | description   | type
        "name" | "description" | IMAGE
        "name" | "description" | VIDEO
        "name" | null          | VIDEO
    }

    def "should not consider asset as valid"() {
        when:
        new NewAsset(name, description, type)

        then:
        def ex = thrown InvalidArgumentException
        ex.getMessage() == expectedErrorMessage

        where:
        name   | description   | type  || expectedErrorMessage
        null   | "description" | IMAGE || INVALID_ARGUMENT_MESSAGE
        "name" | "description" | null  || INVALID_ARGUMENT_MESSAGE
    }
}
