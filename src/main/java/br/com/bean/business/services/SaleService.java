package br.com.bean.business.services;

import br.com.bean.business.converters.SaleConverter;
import br.com.bean.business.dto.SaleDto;
import br.com.bean.business.dto.SaleItemDto;
import br.com.bean.infrastructure.entities.*;
import br.com.bean.infrastructure.exceptions.ResourceNotFoundException;
import br.com.bean.infrastructure.repositories.ProductRepository;
import br.com.bean.infrastructure.repositories.SaleRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
public class SaleService {

    private final SaleRepository repository;
    private final ClientService clientService;
    private final CashSessionService cashSessionService;
    private final UserService userService;
    private final SaleConverter converter;
    private final ProductRepository productRepository;

    public SaleService(SaleRepository repository, SaleConverter converter, ClientService clientService, CashSessionService cashSessionService, UserService userService,
                       ProductRepository productRepository) {
        this.repository = repository;
        this.converter = converter;
        this.clientService = clientService;
        this.cashSessionService = cashSessionService;
        this.userService = userService;
        this.productRepository = productRepository;
    }

    @Transactional(readOnly = true)
    public SaleDto findSaleWithItemsById(Long id) {
        return converter.entityToDto(repository.findSaleWithItemsById(id)
                        .orElseThrow(() -> new ResourceNotFoundException("Sale not found with ID: " + id)));
    }

    @Transactional
    public SaleDto saveSale(SaleDto dto) {
        Client client = clientService.getReferenceByIdOrThrow(dto.getClientId());
        CashSession cashSession = cashSessionService.getReferenceByIdOrThrow(dto.getCashSessionId());
        User user = userService.getReferenceByIdOrThrow(userService.getMe().getId());
        Sale sale = converter.dtoToEntity(dto, client, cashSession, user);

        for(SaleItemDto itemDto : dto.getItems()) {
            Product product = productRepository.getReferenceById(itemDto.getProductId());
            SaleItem item = new SaleItem(sale, product, itemDto.getQuantity(), product.getPrice(), itemDto.getDiscount());
            sale.getItems().add(item);
        }

        return converter.entityToDto(repository.save(sale));
    }
}
