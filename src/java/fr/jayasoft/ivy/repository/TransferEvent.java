/*
 * This file is subject to the license found in LICENCE.TXT in the root directory of the project.
 * 
 * #SNAPSHOT#
 */
package fr.jayasoft.ivy.repository;

import java.io.File;

/**
 * TransferEvent is used to notify TransferListeners about progress in transfer
 * of resources form/to the respository
 * 
 * This class is LARGELY inspired by org.apache.maven.wagon.events.TransferEvent
 * released under the following copyright license:
 * 
 * <pre>
 * 
 *  Copyright 2001-2005 The Apache Software Foundation.
 * 
 *  Licensed under the Apache License, Version 2.0 (the &quot;License&quot;);
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an &quot;AS IS&quot; BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  
 * </pre>
 * 
 * Orginal class written by Michal Maczka.
 * 
 */
public class TransferEvent {
    /**
     * A transfer was attempted, but has not yet commenced.
     */
    public static final int TRANSFER_INITIATED = 0;

    /**
     * A transfer was started.
     */
    public final static int TRANSFER_STARTED = 1;

    /**
     * A transfer is completed.
     */
    public final static int TRANSFER_COMPLETED = 2;

    /**
     * A transfer is in progress.
     */
    public final static int TRANSFER_PROGRESS = 3;

    /**
     * An error occured during transfer
     */
    public final static int TRANSFER_ERROR = 4;

    /**
     * Indicates GET transfer (from the repository)
     */
    public final static int REQUEST_GET = 5;

    /**
     * Indicates PUT transfer (to the repository)
     */
    public final static int REQUEST_PUT = 6;

    private Resource _resource;

    private int _eventType;

    private int _requestType;

    private Exception _exception;

    private File _localFile;

    private Repository _repository;
    private byte[] _buffer;
    private long _length;

    private long _totalLength;

    public TransferEvent(final Repository repository, final Resource resource, final int eventType, final int requestType) {
        _repository = repository;
        _resource = resource;

        setEventType(eventType);

        setRequestType(requestType);

    }

    public TransferEvent(final Repository repository, final Resource resource, final Exception exception, final int requestType) {
        this(repository, resource, TRANSFER_ERROR, requestType);

        _exception = exception;
    }

    public TransferEvent(final Repository repository, final Resource resource, byte[] buffer, long length, final int requestType) {
        this(repository, resource, TRANSFER_PROGRESS, requestType);

        _buffer = buffer;
        _length = length;
        _totalLength = length;
    }

    /**
     * @return Returns the resource.
     */
    public Resource getResource() {
        return _resource;
    }

    /**
     * @return Returns the exception.
     */
    public Exception getException() {
        return _exception;
    }

    /**
     * Returns the request type.
     * 
     * @return Returns the request type. The Request type is one of
     *         <code>TransferEvent.REQUEST_GET<code> or <code>TransferEvent.REQUEST_PUT<code>
     */
    public int getRequestType() {
        return _requestType;
    }

    /**
     * Sets the request type
     * 
     * @param requestType
     *            The requestType to set. The Request type value should be
     *            either
     *            <code>TransferEvent.REQUEST_GET<code> or <code>TransferEvent.REQUEST_PUT<code>.
     * @throws IllegalArgumentException when
     */
    protected void setRequestType(final int requestType) {
        switch (requestType) {

        case REQUEST_PUT:
            break;
        case REQUEST_GET:
            break;

        default:
            throw new IllegalArgumentException("Illegal request type: " + requestType);
        }

        _requestType = requestType;
    }

    /**
     * @return Returns the eventType.
     */
    public int getEventType() {
        return _eventType;
    }

    /**
     * @param eventType
     *            The eventType to set.
     */
    protected void setEventType(final int eventType) {
        switch (eventType) {

        case TRANSFER_INITIATED:
            break;
        case TRANSFER_STARTED:
            break;
        case TRANSFER_COMPLETED:
            break;
        case TRANSFER_PROGRESS:
            break;
        case TRANSFER_ERROR:
            break;
        default:
            throw new IllegalArgumentException("Illegal event type: " + eventType);
        }

        this._eventType = eventType;
    }

    /**
     * @param _resource
     *            The resource to set.
     */
    protected void setResource(final Resource resource) {
        _resource = resource;
    }

    /**
     * @return Returns the local file.
     */
    public File getLocalFile() {
        return _localFile;
    }

    /**
     * @param localFile
     *            The local file to set.
     */
    protected void setLocalFile(File localFile) {
        _localFile = localFile;
    }

    public byte[] getBuffer() {
        return _buffer;
    }
    

    protected void setBuffer(byte[] buffer) {
        _buffer = buffer;
    }
    

    public long getLength() {
        return _length;
    }
    

    protected void setLength(long length) {
        _length = length;
    }

    public long getTotalLength() {
        return _totalLength;
    }

    protected void setTotalLength(long totalLength) {
        _totalLength = totalLength;
    }

    public void setException(Exception exception) {
        _exception = exception;
    }
    
    
    
}
