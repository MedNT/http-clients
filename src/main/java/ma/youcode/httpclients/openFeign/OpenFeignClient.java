package ma.youcode.httpclients.openFeign;

import ma.youcode.httpclients.model.Post;
import ma.youcode.httpclients.utils.JsonPlaceHolder;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "Post", url = "https://jsonplaceholder.typicode.com/posts")
public interface OpenFeignClient {

    @GetMapping
    List<Post> getAll();

    @GetMapping("/{id}")
    Post getById(@PathVariable("id") String id);

}
