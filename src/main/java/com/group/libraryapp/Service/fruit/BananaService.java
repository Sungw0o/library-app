package com.group.libraryapp.Service.fruit;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Qualifier("main")
@Service
public class BananaService implements FruitService {
}
