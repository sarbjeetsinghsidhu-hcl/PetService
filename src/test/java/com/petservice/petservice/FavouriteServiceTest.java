package com.petservice.petservice;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class FavouriteServiceTest {/*
	
	@InjectMocks
	private FavoriteServiceImpl favService;
	
	@Mock
	private FavouriteAccountRepository dao;
	
	private final String mockCustomerId = "789456";
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	void testGetFavouriteAccountByCustomerId() {
		FavouriteAccount favAccountOne = new FavouriteAccount("Test-Account-1","ABCD 1234 456 789");
		FavouriteAccount favAccountTwo = new FavouriteAccount("Test-Account-2","ABCD 1234 456 123");
		FavouriteAccount favAccountThree = new FavouriteAccount("Test-Account-3","ABCD 1234 456 456");
		List<FavouriteAccount> accountList = Arrays.asList(favAccountOne, favAccountTwo, favAccountThree);
		
		Page<FavouriteAccount> page = new PageImpl<>(accountList);
		
		when(dao.findByCustomerId(mockCustomerId, PageRequest.of(0, 5, Sort.Direction.ASC, "account_name"))).thenReturn(page);
		
		List<FavouriteAccount> favAccountList = favService.getFavouriteAccounts(mockCustomerId, 0);
		assertEquals(3, favAccountList.size());
		verify(dao, times(1)).findByCustomerId(mockCustomerId, PageRequest.of(0, 5, Sort.Direction.ASC, "account_name"));
	}
	
	@Test
	void testGetFavouriteAccountByCustomerId_Exception() {
		FavouritesNotFound expectedEx = new FavouritesNotFound(String.format("Favourite accounts are not found against customer Id %s", mockCustomerId));
		List<FavouriteAccount> accountList = new ArrayList<>();
		Page<FavouriteAccount> page = new PageImpl<>(accountList);
		when(dao.findByCustomerId(mockCustomerId, PageRequest.of(0, 5, Sort.Direction.ASC, "account_name"))).thenReturn(page);
		Exception actualEx = assertThrows(FavouritesNotFound.class, ()->{
			favService.getFavouriteAccounts(mockCustomerId, 0);
		});
		assertEquals(expectedEx.getMessage(), actualEx.getMessage());
	}
*/}
