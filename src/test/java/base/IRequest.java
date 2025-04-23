package base;

public interface IRequest<T> {

    T sendRequest();

    void setEndpointPath();

}
