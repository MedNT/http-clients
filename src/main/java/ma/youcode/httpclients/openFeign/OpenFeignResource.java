package ma.youcode.httpclients.openFeign;


import lombok.RequiredArgsConstructor;
import ma.youcode.httpclients.model.Post;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/open-feign")
@RequiredArgsConstructor
public class OpenFeignResource {
    private final OpenFeignClient openFeignClient;

    @GetMapping
    public List<Post> getAll() {
        return this.openFeignClient.getAll();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable("id") String id) {
        return this.openFeignClient.getById(id);
    }
}
