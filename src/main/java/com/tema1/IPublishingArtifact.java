package com.tema1;
public interface IPublishingArtifact {

    /**
     * Method which publishes XML elements
     * @return String instance
     */
    public String publish();

    /**
     * Helper method
     * @return
     */
    public PublishingArtifactType getType();
}
