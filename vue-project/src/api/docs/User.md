# User


## Properties

Name | Type | Description | Notes
------------ | ------------- | ------------- | -------------
**id** | **number** | 用户ID | [optional] [default to undefined]
**username** | **string** | 用户名 | [optional] [default to undefined]
**name** | **string** | 姓名 | [optional] [default to undefined]
**age** | **number** | 年龄 | [optional] [default to undefined]
**email** | **string** | 邮箱 | [optional] [default to undefined]
**department** | **string** | 部门(管理员用户特有) | [optional] [default to undefined]
**permissions** | **Array&lt;string&gt;** | 权限列表(管理员用户特有) | [optional] [default to undefined]

## Example

```typescript
import { User } from './api';

const instance: User = {
    id,
    username,
    name,
    age,
    email,
    department,
    permissions,
};
```

[[Back to Model list]](../README.md#documentation-for-models) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to README]](../README.md)
