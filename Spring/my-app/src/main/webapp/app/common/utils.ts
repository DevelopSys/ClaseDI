import { FormGroup } from '@angular/forms';


/**
* Update all controls of the provided form group with the given data.
*/
export function updateForm(group: FormGroup, data: any) {
  for (const field in group.controls) {
    const control = group.get(field)!;
    let value = data[field] === undefined ? null : data[field];
    control.setValue(value);
  }
}

/**
 * Helper function for transforming a Record to a Map to support number as a key.
 */
export function transformRecordToMap(data:Record<number, number|string>):Map<number, string> {
  const dataMap = new Map();
  for (const [key, value] of Object.entries(data)) {
    dataMap.set(+key, '' + value);
  }
  return dataMap;
}
