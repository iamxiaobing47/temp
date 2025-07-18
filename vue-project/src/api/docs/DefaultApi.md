# DefaultApi

All URIs are relative to *http://localhost:8080*

|Method | HTTP request | Description|
|------------- | ------------- | -------------|
|[**getUser**](#getuser) | **GET** /sampleUser | 获取用户信息|
|[**login**](#login) | **POST** /api/login | 用户登录|
|[**selectAdminUser**](#selectadminuser) | **POST** /api/selectAdminUser | 选择管理员用户|
|[**selectNormalUser**](#selectnormaluser) | **POST** /api/selectNormalUser | 选择普通用户|

# **getUser**
> SampleUser getUser()


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

const { status, data } = await apiInstance.getUser();
```

### Parameters
This endpoint does not have any parameters.


### Return type

**SampleUser**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **login**
> LoginResponse login(requestBody)


### Example

```typescript
import {
    DefaultApi,
    Configuration
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let requestBody: { [key: string]: string; }; //

const { status, data } = await apiInstance.login(
    requestBody
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **requestBody** | **{ [key: string]: string; }**|  | |


### Return type

**LoginResponse**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **selectAdminUser**
> { [key: string]: object; } selectAdminUser(user)


### Example

```typescript
import {
    DefaultApi,
    Configuration,
    User
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let user: User; //

const { status, data } = await apiInstance.selectAdminUser(
    user
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **user** | **User**|  | |


### Return type

**{ [key: string]: object; }**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **selectNormalUser**
> { [key: string]: object; } selectNormalUser(user)


### Example

```typescript
import {
    DefaultApi,
    Configuration,
    User
} from './api';

const configuration = new Configuration();
const apiInstance = new DefaultApi(configuration);

let user: User; //

const { status, data } = await apiInstance.selectNormalUser(
    user
);
```

### Parameters

|Name | Type | Description  | Notes|
|------------- | ------------- | ------------- | -------------|
| **user** | **User**|  | |


### Return type

**{ [key: string]: object; }**

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: application/json
 - **Accept**: */*


### HTTP response details
| Status code | Description | Response headers |
|-------------|-------------|------------------|
|**200** | OK |  -  |

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

