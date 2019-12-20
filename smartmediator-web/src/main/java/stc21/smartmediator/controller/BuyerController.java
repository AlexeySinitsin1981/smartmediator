package stc21.smartmediator.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import stc21.smartmediator.dto.ListOfOrders;
import stc21.smartmediator.dto.Order;
import stc21.smartmediator.entity.*;
import stc21.smartmediator.repository.*;
import stc21.smartmediator.service.OrdersServiceImpl;
import stc21.smartmediator.service.ProductServiceImpl;
import stc21.smartmediator.service.SellersServiceImp;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.*;

@Controller
//@PreAuthorize("hasAuthority('BUYER')")
public class BuyerController {

    private final OrdersRepository ordersRepository;

    private final SellersRepository sellersRepository;

    private final OrderStatusesRepository orderStatusesRepository;

    private final OrganizationsRepository organizationsRepository;

    private final OrdersProductsRepository ordersProductsRepository;

    @Autowired
    private OrdersServiceImpl service;

    @Autowired
    private SellersServiceImp sellerService;

    @Autowired
    private ProductServiceImpl productService;

    @Autowired
    BuyersRepository buyersRepository;

    @Autowired
    DeliveryTypesRepository deliveryTypesRepository;

    @Autowired
    PricePatternsRepository pricePatternsRepository;

    @Autowired
    LogisticsPointsRepository logisticsPointsRepository;

    public BuyerController(OrdersRepository ordersRepository, SellersRepository sellersRepository, OrderStatusesRepository orderStatusesRepository, OrganizationsRepository organizationsRepository, OrdersProductsRepository ordersProductsRepository) {
        this.ordersRepository = ordersRepository;
        this.sellersRepository = sellersRepository;
        this.orderStatusesRepository = orderStatusesRepository;
        this.organizationsRepository = organizationsRepository;
        this.ordersProductsRepository = ordersProductsRepository;
    }

    @GetMapping("/buyer")
    public String main(Map<String, Object> model) {
        List orders = service.findAll();
        model.put("orders", orders);

        return "buyer/buyerorders";
    }

    @GetMapping("/buyer/orders/{id}")
    public String editOrder(@PathVariable UUID id, Map<String, Object> model) {
        OrdersEntity order = service.findById(id);
        model.put("order", order);

        return "buyer/showorder";
    }

    @GetMapping("/buyer/bids")
    public String orders(Map<String, Object> model) {

        return "buyer/buyerbids";
    }

    @GetMapping("/buyer/create")
    public String orderscreate(@ModelAttribute("seller") String seller,
                               @ModelAttribute("nameSeller") String nameSeller,
                               @ModelAttribute ListOfOrders listOfOrdersv,
                               @ModelAttribute("date") String date,
                               @RequestParam(required = false) String yes,
                               Map<String, Object> model) {

        List<SellersEntity> sellersEntities = sellerService.findAll();
        model.put("sellers", sellersEntities);
        ListOfOrders listOfOrders;

        if ("yes".equals(yes)) {

//            OrderStatusesEntity oNew = orderStatusesRepository.findByCode("new");
//            Optional<OrganizationsEntity> ogrRog = organizationsRepository.findByInn("1234599999011450");
//            SellersEntity seeee = (SellersEntity) sellersRepository.findByOrgId(ogrRog.get().getId());

//            OrderStatusesEntity oNew = new OrderStatusesEntity("new", "Новый");
//            Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//            Object principal = auth.getPrincipal();
//            SellersEntity sellersEntity = sellerService.findById(UUID.fromString(nameSeller)).get();
//            DeliveryTypesEntity supply = new DeliveryTypesEntity("supply", "Доставка");
//            PricePatternsEntity pricePatternsEntity = new PricePatternsEntity("magnit", "Магнит",
//                    null, "", sellersEntity.getId());
//            OrgStatusesEntity orgStatusesEntity = new OrgStatusesEntity("new", "Новый");
//            OrganizationsEntity mag = new OrganizationsEntity("ООО Магнезит",
//                    "ООО Магнезит", "1234567891011450",
//                    "Ул. Мира 61", orgStatusesEntity.getId());
//            LogisticsPointsEntity logis = new LogisticsPointsEntity("point", "Точка обмена",
//                    "Бейкер стрит 221", mag.getId());
//            int n = 1522;

//            SellersEntity sellersEntity11 = new SellersEntity();
//            sellersRepository.save(sellersEntity11);
//            sellersEntity.setOrg(rogok);
//            sellersRepository.save(sellersEntity);


//            for (Order order : listOfOrdersv.getOrders()) {
//                OrdersEntity o1 = new OrdersEntity();
//                ordersRepository.save(o1);
//                o1.setStatus(oNew);
//                o1.setBuyer((BuyersEntity) principal);
//                o1.setSeller(seeee);
//                o1.setDeliveryTypeId(supply.getId());
//                o1.setPricePatternId(pricePatternsEntity.getId());
//                o1.setGetFrom(logis.getId());
//                o1.setSetTo(logis.getId());
//                o1.setNumber(BigDecimal.valueOf(n++));
//                o1.setPrice(BigDecimal.valueOf(45851));
//                o1.setCreateDate(new Timestamp(System.currentTimeMillis()));
//                ordersRepository.save(o1);
//
//                System.out.println(";");

            OrderStatusesEntity oNew = orderStatusesRepository.findByCode("new");
            BuyersEntity buyersEntity = buyersRepository.findAll().get(0);
            SellersEntity sellersEntity = sellersRepository.findAll().get(0);
            DeliveryTypesEntity deliveryTypesEntity = deliveryTypesRepository.findAll().get(0);
            PricePatternsEntity pricePatternsEntity = pricePatternsRepository.findAll().get(0);
            LogisticsPointsEntity logisticsPointsEntity = logisticsPointsRepository.findAll().get(0);


            Optional<BigDecimal> n=ordersRepository.findAll().stream().map(s->s.getNumber()).max(new Comparator<BigDecimal>() {
                @Override
                public int compare(BigDecimal o1, BigDecimal o2) {
                    return o1.compareTo(o2);
                }
            });
            BigDecimal summ = BigDecimal.valueOf(0);
            for (Order order : listOfOrdersv.getOrders()) {
                if (order.getAmount() == 0) {
                    continue;
                }

                BigDecimal s1 = order.getPrice();
                BigDecimal s2 = BigDecimal.valueOf(order.getAmount());
                summ = summ.add(s1.multiply(s2));

            }

//            for (Order order : listOfOrdersv.getOrders()) {
            OrdersEntity o1 = new OrdersEntity();
            ordersRepository.save(o1);
            o1.setStatus(oNew);
            o1.setBuyer(buyersEntity);
            o1.setSeller(sellersEntity);
            o1.setSeller(sellersEntity);
            o1.setDeliveryTypeId(deliveryTypesEntity.getId());
            o1.setPricePatternId(pricePatternsEntity.getId());
            o1.setSetTo(logisticsPointsEntity.getId());
            o1.setGetFrom(logisticsPointsEntity.getId());
            o1.setNumber((n.get().add(BigDecimal.ONE)));
            o1.setCreateDate(new Timestamp(System.currentTimeMillis()));
            o1.setPrice(summ);
            ordersRepository.save(o1);

            for (Order order : listOfOrdersv.getOrders()) {
                if (order.getAmount() == 0) {
                    continue;
                }
                OrdersProductsEntity uuu = ordersProductsRepository.save(new OrdersProductsEntity());
                uuu.setPrice(order.getPrice());
                uuu.setAmount(BigDecimal.valueOf(order.getAmount()));
                uuu.setProduct(order.getProduct());
                uuu.setOrder(o1);
                BigDecimal s1 = order.getPrice();
                BigDecimal s2 = BigDecimal.valueOf(order.getAmount());
                uuu.setPrice(s1);
                summ = summ.add(s1.multiply(s2));
                ordersProductsRepository.save(uuu);
            }

            o1.setPrice(summ);
//            ordersRepository.save(o1);
//            }
//            for (OrdersEntity ordersEntity : ordersRepository.findAll()) {
//                ordersEntity.setDeleted(0);
//            }

        } else if ("".equals(seller)) {
            //listOfOrders = new ListOfOrders(productService.findAll());
            listOfOrders = new ListOfOrders();
            model.put("listOfOrders", listOfOrders);
        } else {
            listOfOrders = new ListOfOrders(productService.findAllBySellerId(seller));
            model.put("listOfOrders", listOfOrders);
            model.put("nameSeller", seller);
        }

        System.out.println("ddd");

        return "buyer/buyercreate";
    }

//    @GetMapping("/buyer/bids")
//    public String requests(Map<String, Object> model) {
//        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
//        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
//        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
//        userEntorganizationsEntity1.setFullName("Vasia");
//        userEntorganizationsEntity1.setAddress("Люберцы");
//        userEntorganizationsEntity1.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setFullName("Ania");
//        userEntorganizationsEntity2.setAddress("Mosckow");
//        listOfOrganizations.add(userEntorganizationsEntity1);
//        listOfOrganizations.add(userEntorganizationsEntity2);
//        model.put("listOfOrganizations", listOfOrganizations);
//        return "buyer/buyerbids";
//    }

//    @GetMapping("/buyer/history")
//    public String history(Map<String, Object> model) {
//        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
//        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
//        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
//        userEntorganizationsEntity1.setFullName("Vasia");
//        userEntorganizationsEntity1.setAddress("Люберцы");
//        userEntorganizationsEntity1.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setFullName("Ania");
//        userEntorganizationsEntity2.setAddress("Mosckow");
//        listOfOrganizations.add(userEntorganizationsEntity1);
//        listOfOrganizations.add(userEntorganizationsEntity2);
//        model.put("listOfOrganizations", listOfOrganizations);
//
//        return "buyer/buyerhistory";
//    }

//    @GetMapping("/buyer/data")
//    public String data(Map<String, Object> model) {
//        List<OrganizationsEntity> listOfOrganizations = new ArrayList<>();
//        OrganizationsEntity userEntorganizationsEntity1 = new OrganizationsEntity();
//        OrganizationsEntity userEntorganizationsEntity2 = new OrganizationsEntity();
//        userEntorganizationsEntity1.setFullName("Vasia");
//        userEntorganizationsEntity1.setAddress("Люберцы");
//        userEntorganizationsEntity1.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setId(new UUID(1, 2));
//        userEntorganizationsEntity2.setFullName("Ania");
//        userEntorganizationsEntity2.setAddress("Mosckow");
//        listOfOrganizations.add(userEntorganizationsEntity1);
//        listOfOrganizations.add(userEntorganizationsEntity2);
//        model.put("listOfOrganizations", listOfOrganizations);
//        return "buyer/buyerdata";
//}

}
